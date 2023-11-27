package com.betek.interactivetInnovationEducation.configuration;

public class Constants {
    private Constants() { throw new IllegalStateException("Utility class");}

    public static final String POSTS_CREATED_MESSAGE = "The Post was created.";
    public static final String POST_DELETED_MESSAGE = "The post was deleted.";
    public static final String CATEGORY_CREATED_MESSAGE = "The category was created.";
    public static final String CATEGORY_DELETED_MESSAGE = "The category was deleted.";
    public static final String RESPONSE_MESSAGE_KEY = "message";

    public static final String ROLE_ADMINSITRATOR = "ADMINISTRATOR_ROLE";
    public static final String ROLE_MEMBER = "MEMBER_ROLE";

    // exceptions

    public static final String RESPONSE_ERROR_MESSAGE_KEY = "error";
    public static final String WRONG_CREDENTIALS_MESSAGE = "Wrong credentials or role not allowed";
    public static final String DIFFERENT_POST_DELETE_ERROR = "The post belong other user.";
    public static final String HOME_CATEGORIES_FILTER_EXCEPTION = "The categories filter is error.";

    //
    public static final String SWAGGER_TITLE_MESSAGE = "Management Red Conocimiento";
    public static final String SWAGGER_DESCRIPTION_MESSAGE = "Management microservice";
    public static final String SWAGGER_VERSION_MESSAGE = "1.0.0";
    public static final String SWAGGER_LICENSE_NAME_MESSAGE = "Apache 2.0";
    public static final String SWAGGER_LICENSE_URL_MESSAGE = "http://springdoc.org";
    public static final String SWAGGER_TERMS_OF_SERVICE_MESSAGE = "http://swagger.io/terms/";
}
