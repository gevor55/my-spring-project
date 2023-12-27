package com.myspringproject.advice;

import org.springframework.util.Assert;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Error {

    private String objectName;
    private String field;
    private List<String> code;
    private String defaultMessage;
    private Object rejectedValue;
    private Map<String, Object> attributes;
    private Collection<Object> arguments;

    Error(String objectName, String field, List<String> code, String defaultMessage, Object rejectedValue, Map<String, Object> attributes, Collection<Object> arguments) {
        this.objectName = objectName;
        this.field = field;
        this.code = code;
        this.defaultMessage = defaultMessage;
        this.rejectedValue = rejectedValue;
        this.attributes = attributes;
        this.arguments = arguments;
    }

    public static Error.ErrorBuilder builder() {
        return new Error.ErrorBuilder();
    }

    public String getObjectName() {
        return this.objectName;
    }

    public String getField() {
        return this.field;
    }

    public List<String> getCode() {
        return this.code;
    }

    public String getDefaultMessage() {
        return this.defaultMessage;
    }

    public Object getRejectedValue() {
        return this.rejectedValue;
    }

    public Map<String, Object> getAttributes() {
        return this.attributes;
    }

    public Collection<Object> getArguments() {
        return this.arguments;
    }

    public void setObjectName(final String objectName) {
        this.objectName = objectName;
    }

    public void setField(final String field) {
        this.field = field;
    }

    public void setCode(final List<String> code) {
        this.code = code;
    }

    public void setDefaultMessage(final String defaultMessage) {
        this.defaultMessage = defaultMessage;
    }

    public void setRejectedValue(final Object rejectedValue) {
        this.rejectedValue = rejectedValue;
    }

    public void setAttributes(final Map<String, Object> attributes) {
        this.attributes = attributes;
    }

    public void setArguments(final Collection<Object> arguments) {
        this.arguments = arguments;
    }

    public String toString() {
        String var10000 = this.getField();
        return "Error(field=" + var10000 + ", code=" + this.getCode() + ", defaultMessage=" + this.getDefaultMessage() + ", attributes=" + this.getAttributes() + ", arguments=" + this.getArguments() + ")";
    }

    public static class ErrorBuilder {
        private String objectName;
        private String field;
        private List<String> code;
        private String defaultMessage;
        private Object rejectedValue;
        private Map<String, Object> attributes;

        ErrorBuilder() {
        }

        public Error.ErrorBuilder objectName(String objectName) {
            this.objectName = objectName;
            return this;
        }

        public Error.ErrorBuilder field(String field) {
            this.field = field;
            return this;
        }

        public Error.ErrorBuilder code(List<String> code) {
            this.code = code;
            return this;
        }

        public Error.ErrorBuilder code(String code) {
            return this.code(List.of(code));
        }

        public Error.ErrorBuilder defaultMessage(String defaultMessage) {
            this.defaultMessage = defaultMessage;
            return this;
        }

        public Error.ErrorBuilder rejectedValue(Object rejectedValue) {
            this.rejectedValue = rejectedValue;
            return this;
        }

        public Error.ErrorBuilder attributes(Map<String, Object> attributes) {
            this.attributes = attributes;
            return this;
        }

        public Error.ErrorBuilder addAttribute(String name, Object value) {
            ArgsCheck.notNull(name, "name");
            if (this.attributes == null) {
                this.attributes = new LinkedHashMap();
            }

            this.attributes.put(name, value);
            return this;
        }

        public Error.ErrorBuilder addAttributes(Object... nameValues) {
            int nameValuesLength = ((Object[]) ArgsCheck.notNull(nameValues, "nameValues")).length;
            Assert.isTrue(nameValuesLength % 2 == 0, "Length of nameValues can't be odd.");
            int end = nameValuesLength - 2;
            if (this.attributes == null) {
                this.attributes = new LinkedHashMap();
            }

            for (int i = 0; i <= end; i += 2) {
                this.attributes.put(nameValues[i].toString(), nameValues[i + 1]);
            }

            return this;
        }

        public Error build() {
            Collection args;
            if (this.attributes == null) {
                args = null;
            } else {
                args = this.attributes.values();
            }

            return new Error(this.objectName, this.field, this.code, this.defaultMessage, this.rejectedValue, this.attributes, args);
        }

        public String toString() {
            return "Error.ErrorBuilder(objectName=" + this.objectName + ", field=" + this.field + ", code=" + this.code + ", defaultMessage=" + this.defaultMessage + ", rejectedValue=" + this.rejectedValue + ", attributes=" + this.attributes + ")";
        }
    }
}
