package za.ac.nwu.account.system.web.sb.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.nwu.account.system.domain.GeneralResponse;

@RestController
@RequestMapping("accounts")
public class AccountsController {
        @GetMapping("/all")
        @ApiOperation(value = "Get all configured Accounts", notes = "Return a list of Account Types")
        @ApiResponses(value = {
                @ApiResponse(code = 200, message = "Account Types returned", response = GeneralResponse.class),
                @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
                @ApiResponse(code = 404, message = "Not found", response = GeneralResponse.class),
                @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
        public ResponseEntity<GeneralResponse<String>> getAll(){
                GeneralResponse<String> response = new GeneralResponse(true, "No Account type");
                return new ResponseEntity<>(response, HttpStatus.OK);
        }
}
