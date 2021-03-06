package io.garam.core.http;

/**
 * Interface to be implemented by objects that represent response to client through http.
 *
 * @author hyeyoom
 */
public interface Response {

    /**
     * @param status the status to set for response
     * @return response itself
     */
    Response status(HttpStatus status);

    /**
     * @param contentType the type that specifies the MIME type of the content
     * @return response itself
     */
    Response contentType(String contentType);

    /**
     * @param path the path to move
     * @return response itself
     */
    Response redirect(String path);

    /**
     * @param name the name of header
     * @param value the value of header
     * @return response itself
     */
    Response header(String name, String value);

    /**
     * @param status Response Status
     * @param body the message body
     * @return response itself
     */
    Response text(HttpStatus status, String body);

    /**
     * @param status Response Status
     * @param body the message body
     * @return response itself
     */
    Response html(HttpStatus status, String body);

    /**
     * @param status Response Status
     * @param body json
     * @return response itself
     */
    Response json(HttpStatus status, Object body);

    /**
     * @param status Response status
     * @param body prettified json
     * @return response itself
     */
    Response prettifiedJson(HttpStatus status, Object body);
}
