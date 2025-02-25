package br.notificaai.application.ports.input.controllers;

import java.util.ArrayList;
import java.util.List;

import jakarta.ws.rs.Produces;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.notificaai.application.ports.input.model.TvSeries;
import br.notificaai.application.ports.input.proxy.TvSeriesProxy;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/tvseries")
public class TvSeriesController {
    @RestClient
    TvSeriesProxy proxy;

    @JsonProperty("TvSeries")
    private List<TvSeries> tvSeriesList = new ArrayList<>();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response get() {
        TvSeries tvSeries = proxy.get("game of thrones");
        tvSeriesList.add(tvSeries);
        return Response.ok(tvSeries).build();
    }
}
