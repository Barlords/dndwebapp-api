package fr.barlords.dndwebappapi.external.minio;

public class MinioFetchException extends RuntimeException{
    public MinioFetchException(String message, Throwable cause) {
        super(message, cause);
    }
}