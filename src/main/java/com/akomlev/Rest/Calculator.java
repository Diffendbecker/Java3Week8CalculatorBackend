package com.akomlev.Rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;

@Path("/calculate")
public class Calculator {

    @GET
    @Path("/{expression}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response Calculate(@PathParam("expression") String expression) throws Exception {

        if(expression == null || expression.trim().length() == 0) {
            return Response.serverError().entity("Expression cannot be blank").build();
        }

        CalculatorService calculatorService = new CalculatorService();
        String expressionResult = calculatorService.Calculate(expression);

        if(CheckExpressionResult(expressionResult)) {
            return Response.status(Response.Status.NOT_FOUND).entity("Expression is wrong. Example: '2*1.5'").build();
        }

        return Response.status(200).entity(expressionResult).build();
    }

    @GET
    @Path("/multiply/{a}/{b}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response Multiplication(@PathParam("a") String value1,
                                   @PathParam("b") String value2) throws Exception {

        if(CheckInputValues(value1, value2)) {
            return Response.serverError().entity("Values cannot be blank. Example: /{multiply/{a}/{b}").build();
        }

        float value1Float;
        float value2Float;

        try {
            value1Float = Float.parseFloat(value1.trim());
        }
        catch(Exception ex)
        {
            String errorMessage = "Value: " + value1 + " is incorrect.";
            return Response.status(400).entity(errorMessage).build();
        }

        try {
            value2Float = Float.parseFloat(value2.trim());
        }
        catch(Exception ex)
        {
            String errorMessage = "Value: " + value2 + " is incorrect.";
            return Response.status(400).entity(errorMessage).build();
        }

        CalculatorService calculatorService = new CalculatorService();
        String expressionResult = calculatorService.CalculateTwoValues(value1Float, value2Float, "*");

        if(CheckExpressionResult(expressionResult)) {
            return Response.status(503).entity("Internal Error").build();
        }

        return Response.status(200).entity(expressionResult).build();
    }

    @GET
    @Path("/divide/{a}/{b}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response Division(@PathParam("a") String value1,
                             @PathParam("b") String value2) throws Exception {

        if(CheckInputValues(value1, value2)) {
            return Response.serverError().entity("Values cannot be blank. Example: /divide/{a}/{b}").build();
        }

        float value1Float;
        float value2Float;

        try {
            value1Float = Float.parseFloat(value1.trim());
        }
        catch(Exception ex)
        {
            String errorMessage = "Value: " + value1 + " is incorrect.";
            return Response.status(400).entity(errorMessage).build();
        }

        try {
            value2Float = Float.parseFloat(value2.trim());
        }
        catch(Exception ex)
        {
            String errorMessage = "Value: " + value2 + " is incorrect.";
            return Response.status(400).entity(errorMessage).build();
        }

        CalculatorService calculatorService = new CalculatorService();
        String expressionResult = calculatorService.CalculateTwoValues(value1Float, value2Float, "|");

        if(CheckExpressionResult(expressionResult)) {
            return Response.status(503).entity("Internal Error").build();
        }

        return Response.status(200).entity(expressionResult).build();
    }

    @GET
    @Path("/add/{a}/{b}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response Add(@PathParam("a") String value1,
                        @PathParam("b") String value2) throws Exception {

        if(CheckInputValues(value1, value2)) {
            return Response.serverError().entity("Values cannot be blank. Example: /add/{a}/{b}").build();
        }

        float value1Float;
        float value2Float;

        try {
            value1Float = Float.parseFloat(value1.trim());
        }
        catch(Exception ex)
        {
            String errorMessage = "Value: " + value1 + " is incorrect.";
            return Response.status(400).entity(errorMessage).build();
        }

        try {
            value2Float = Float.parseFloat(value2.trim());
        }
        catch(Exception ex)
        {
            String errorMessage = "Value: " + value2 + " is incorrect.";
            return Response.status(400).entity(errorMessage).build();
        }

        CalculatorService calculatorService = new CalculatorService();
        String expressionResult = calculatorService.CalculateTwoValues(value1Float, value2Float, "+");

        if(CheckExpressionResult(expressionResult)) {
            return Response.status(503).entity("Internal Error").build();
        }

        return Response.status(200).entity(expressionResult).build();
    }

    @GET
    @Path("/subtract/{a}/{b}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response Subtract(@PathParam("a") String value1,
                             @PathParam("b") String value2) throws Exception {

        if(CheckInputValues(value1, value2)) {
            return Response.serverError().entity("Values cannot be blank. Example: /subtract/{a}/{b}").build();
        }

        float value1Float;
        float value2Float;

        try {
            value1Float = Float.parseFloat(value1.trim());
        }
        catch(Exception ex)
        {
            String errorMessage = "Value: " + value1 + " is incorrect.";
            return Response.status(400).entity(errorMessage).build();
        }

        try {
            value2Float = Float.parseFloat(value2.trim());
        }
        catch(Exception ex)
        {
            String errorMessage = "Value: " + value2 + " is incorrect.";
            return Response.status(400).entity(errorMessage).build();
        }

        CalculatorService calculatorService = new CalculatorService();
        String expressionResult = calculatorService.CalculateTwoValues(value1Float, value2Float, "-");

        if(CheckExpressionResult(expressionResult)) {
            return Response.status(503).entity("Internal Error").build();
        }

        return Response.status(200).entity(expressionResult).build();
    }

    private boolean CheckExpressionResult(String expressionResult)
    {
        return expressionResult == null || expressionResult.trim().length() == 0;
    }

    private boolean CheckInputValues(String value1, String value2)
    {
        return value1 == null || value1.trim().length() == 0 || value2 == null || value2.trim().length() == 0;
    }
}