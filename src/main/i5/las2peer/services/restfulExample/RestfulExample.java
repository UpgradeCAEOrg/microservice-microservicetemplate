package i5.las2peer.services.restfulExample;


import java.net.HttpURLConnection;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;

import i5.las2peer.api.Context;
import i5.las2peer.api.ManualDeployment;
import i5.las2peer.api.ServiceException;
import i5.las2peer.restMapper.RESTService;
import i5.las2peer.restMapper.annotations.ServicePath;
import i5.las2peer.services.restfulExample.database.DatabaseManager;
import java.sql.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Contact;
import io.swagger.annotations.Info;
import io.swagger.annotations.License;
import io.swagger.annotations.SwaggerDefinition;
import org.json.simple.*;
 

/**
 *
 * microservicetemplate
 *
 * This microservice was generated by the CAE (Community Application Editor). If you edit it, please
 * make sure to keep the general structure of the file and only add the body of the methods provided
 * in this main file. Private methods are also allowed, but any "deeper" functionality should be
 * outsourced to (imported) classes.
 *
 */
@ServicePath("RestfulExample")
@ManualDeployment
public class RestfulExample extends RESTService {


  /*
   * Database configuration
   */
  private String jdbcDriverClassName;
  private String jdbcLogin;
  private String jdbcPass;
  private String jdbcUrl;
  private static DatabaseManager dbm;



  public RestfulExample() {
	super();
    // read and set properties values
    setFieldValues();
        // instantiate a database manager to handle database connection pooling and credentials
    dbm = new DatabaseManager(jdbcDriverClassName, jdbcLogin, jdbcPass, jdbcUrl);
  }

  @Override
  public void initResources() {
	getResourceConfig().register(RootResource.class);
  }

  // //////////////////////////////////////////////////////////////////////////////////////
  // REST methods
  // //////////////////////////////////////////////////////////////////////////////////////

  @Api
  @SwaggerDefinition(
      info = @Info(title = "microservicetemplate", version = "1.0",
          description = "A las2peer microservice generated by the CAE.",
          termsOfService = "none",
          contact = @Contact(name = "", email = "CAEAddress@gmail.com") ,
          license = @License(name = "BSD",
              url = "https://github.com/UpgradeCAEOrg/microservice-microservicetemplate/blob/master/LICENSE.txt") ) )
  @Path("/")
  public static class RootResource {

    private final RestfulExample service = (RestfulExample) Context.getCurrent().getService();

      /**
   * 
   * postTrack
   * 
   * @param trackId a JSONObject 
   * 
   * @return Response  
   * 
   */
  @POST
  @Path("/postTrack")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.TEXT_PLAIN)
  @ApiResponses(value = {
       @ApiResponse(code = HttpURLConnection.HTTP_OK, message = "ok")
  })
  @ApiOperation(value = "postTrack", notes = " ")
  public Response postTrack(String trackId) {
    JSONObject trackId_JSON = (JSONObject) JSONValue.parse(trackId);

    // ok
    boolean ok_condition = true;
    if(ok_condition) {
      JSONObject ok = new JSONObject();
      return Response.status(HttpURLConnection.HTTP_OK).entity(ok.toJSONString()).build();
    }
    return null;
  }

  /**
   * 
   * getTrack
   * 
   * @param trackId a String 
   * 
   * @return Response  
   * 
   */
  @GET
  @Path("/getTrack/{trackId}")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.TEXT_PLAIN)
  @ApiResponses(value = {
       @ApiResponse(code = HttpURLConnection.HTTP_OK, message = "trackFound")
  })
  @ApiOperation(value = "getTrack", notes = " ")
  public Response getTrack(@PathParam("trackId") String trackId) {

    return null;
  }



  }

  // //////////////////////////////////////////////////////////////////////////////////////
  // Service methods (for inter service calls)
  // //////////////////////////////////////////////////////////////////////////////////////
  
  

}
