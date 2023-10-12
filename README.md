# my-spring-project
## Description

This is a User Management application ,  sends email notifications via Gmail, and includes JWT authentication settings. Before running the application, it's important
to perform a few setup steps as described below.

## Setting Up Gmail for Sending Email Notifications

Before starting the application, you need to configure your Gmail account to send email notifications.
In the `application.yml` file, specify your valid email under the `mail` section and generate a password for use in the application. Then, insert this password in the `password` field. For example:

```yaml
mail:
  host: smtp.gmail.com
  port: 587
  username: your_valid_email@gmail.com
  password: your generated password from gmail
  properties:
    mail:
      smtp:
        auth: true
        starttls:
          enable: true
