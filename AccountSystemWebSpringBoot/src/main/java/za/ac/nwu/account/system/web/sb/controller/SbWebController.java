package za.ac.nwu.account.system.web.sb.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.nwu.account.system.domain.service.GeneralResponse;
import za.ac.nwu.account.system.domain.service.Pong;

@RestController
@RequestMapping("sbweb")
public class SbWebController {
        @GetMapping("/ping")
        @ApiOperation(value = "Echo the Ping.", notes = "This echo the ping back to  the client")
        @ApiResponses(value = {
                @ApiResponse(code = 200, message = "The Ping was received and echoed", response = GeneralResponse.class),
                @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
                @ApiResponse(code = 404, message = "Not found", response = GeneralResponse.class),
                @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
        public ResponseEntity<GeneralResponse<String>> ping(
                @RequestParam(value = "echo", defaultValue = "pong")
                        String echo) {
                GeneralResponse<String> response = new GeneralResponse(true, echo);
                return new ResponseEntity<>(response, HttpStatus.OK);
        }
        @GetMapping("")
        @ApiOperation(value = "Echo the Ping.", notes = "This echo the ping back to  the client")
        @ApiResponses(value = {
                @ApiResponse(code = 200, message = "The Ping was received and echoed", response = GeneralResponse.class),
                @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
                @ApiResponse(code = 404, message = "Not found", response = GeneralResponse.class),
                @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
        public ResponseEntity<GeneralResponse<String>> getPing(
                @RequestParam(value = "echo", defaultValue = "pong",required = false)
                        String echo) {
                GeneralResponse<String> response = new GeneralResponse(true, echo);
                return new ResponseEntity<>(response, HttpStatus.OK);
        }
        @PostMapping("/ping")
        @ApiOperation(value = "Creates a new Pong", notes = "Creates an Pong in the system")
        @ApiResponses(value = {
                @ApiResponse(code = 201, message = "The Pong was created succesfully", response = GeneralResponse.class),
                @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
                @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
        public ResponseEntity<GeneralResponse<Pong>> postPong(
                @ApiParam(value = "Request body to create new a Pong",
                required = true)
                @RequestBody Pong pong){
                GeneralResponse<Pong> response = new GeneralResponse(true, pong);
                return new ResponseEntity<>(response, HttpStatus.CREATED);
        }
        @PutMapping("/ping")
        @ApiOperation(value = "Update the pong.")
        @ApiResponses(value = {
                @ApiResponse(code = 200, message = "The Pong was updated", response = GeneralResponse.class),
                @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
                @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
        public ResponseEntity<GeneralResponse<String>> putPong(
                @RequestParam(value = "The number of Days to add", defaultValue = "2")
                        int daysToAdd,
                        @ApiParam(value = "The Pong",
                        required = true)
                        @RequestBody Pong pong){
                pong.setOnDate(pong.getOnDate().plusDays(daysToAdd));
                GeneralResponse<Pong> response = new GeneralResponse(true, pong);
                return new ResponseEntity<>(response, HttpStatus.OK);
        }
        @DeleteMapping("/ping")
        @ApiOperation(value = "Delete the Pong")
        @ApiResponses(value = {
                @ApiResponse(code = 200, message = "The Pong was deleted", response = GeneralResponse.class),
                @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
                @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
        public ResponseEntity<GeneralResponse<Pong>>deletePong(
                @ApiParam(value = "The Pong.",
                        required = true)
                @RequestBody Pong pong){
                GeneralResponse<Pong>response=new GeneralResponse<>(true,pong);
                return new ResponseEntity<>(response,HttpStatus.OK);
        }
        @GetMapping("/error")
        @ApiOperation(value="Throw exception")
        @ApiResponses(value ={
                @ApiResponse(code = 200, message = "The Ping was received and echoed", response = GeneralResponse.class),
                @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
                @ApiResponse(code = 404, message = "Not found", response = GeneralResponse.class),
                @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
        public ResponseEntity<GeneralResponse<String>>ping() {
                throw new RuntimeException("Give an error");
        }

}
