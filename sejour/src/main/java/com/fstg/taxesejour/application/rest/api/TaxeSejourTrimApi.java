package com.fstg.taxesejour.application.rest.api;

import com.fstg.taxesejour.application.dto.TaxeSejourTrimDto;
import com.fstg.taxesejour.application.dto.TaxeSejourTrimDtoResponse;
import com.fstg.taxesejour.domaine.core.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

import static com.fstg.taxesejour.utils.Constant.TAXE_TRIM_ENDPOINT;

@RequestMapping(value = TAXE_TRIM_ENDPOINT)
public interface TaxeSejourTrimApi {
    @GetMapping(value = "/")
    List<TaxeSejourTrimDtoResponse> findAll();
//
//    @GetMapping(value = "/ref/{ref}")
//    @ApiOperation(value = "Taxe Trim By Refrence", notes = "Taxe Trim By Refrence", response = TaxeSejourTrimDto.class)
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "Taxe Trim By Refrence")
//    })
//    TaxeSejourTrimDto findByReferance(@PathVariable String ref);
//
//
//    @DeleteMapping(value = "/ref/{ref}")
//    @ApiOperation(value = "Delete Taxe Trim By Refrence", notes = "Delete Taxe Trim By Refrence", response = TaxeSejourTrimDto.class)
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "Delete Taxe Trim By Refrence")
//    })
//    int deleteByRef(@PathVariable String ref);
//
//    @GetMapping(value = "/year/{year}")
//    @ApiOperation(value = "Find Taxe Trim By year", notes = "Find Taxe Trim By year", response = TaxeSejourTrimDto.class)
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "Find Taxe Trim By year")
//    })
//    TaxeSejourTrimDto findByAnnee(@PathVariable() int year);
//
//
//    @GetMapping(value = "/dateValidation/{dateValidation}")
//    @ApiOperation(value = "Find Taxe Trim By Date Validation", notes = "Find Taxe Trim By Date Validation", response = TaxeSejourTrimDto.class)
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "Find Taxe Trim By Date Validation")
//    })
//    TaxeSejourTrimDto findByDateValidation(@PathVariable() Date dateValidation);

    @PostMapping(value = "/")
//    @ApiOperation(value = "Add new Taxe", notes = "Add new Taxe Sejour", response = Integer.class)
//    @ApiResponses(value = {
//            @ApiResponse(code = 201, message = "Add new Taxe Sejour")
//    })
    Result save(@RequestBody @Valid TaxeSejourTrimDto taxeSejourTrimDto);
}
