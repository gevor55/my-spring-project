package com.myspringproject.service.xlsx;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;

@Service
public class ExcelService {
    public <T> ByteArrayInputStream generateExcel(List<T> entities) {
        try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            Class<?> entityType = entities.get(0).getClass();
            String[] headers = getEntityFieldNames(entityType);
            String sheetName = entityType.getSimpleName();

            Sheet sheet = workbook.createSheet(sheetName);

            // Header
            Row headerRow = sheet.createRow(0);
            for (int col = 0; col < headers.length; col++) {
                Cell cell = headerRow.createCell(col);
                cell.setCellValue(headers[col]);
            }

            int rowIdx = 1;
            for (T entity : entities) {
                Row row = sheet.createRow(rowIdx++);
                int colIdx = 0;
                for (String fieldName : headers) {
                    Field field = entityType.getDeclaredField(fieldName);
                    field.setAccessible(true);
                    Object value = field.get(entity);
                    row.createCell(colIdx++).setCellValue(value.toString());
                }
            }

            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        } catch (IOException | NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException("Fail to generate Excel: " + e.getMessage());
        }
    }

    private String[] getEntityFieldNames(Class<?> entityType) {
        Field[] fields = entityType.getDeclaredFields();
        String[] fieldNames = new String[fields.length];
        for (int i = 0; i < fields.length; i++) {
            fieldNames[i] = fields[i].getName();
        }
        return fieldNames;
    }
}