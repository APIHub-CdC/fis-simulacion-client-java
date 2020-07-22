package io.fis.simulacion.mx.client.api;

import io.fis.simulacion.mx.client.model.CatalogoEstados;
import io.fis.simulacion.mx.client.ApiClient;
import io.fis.simulacion.mx.client.api.ApiTest;
import io.fis.simulacion.mx.client.ApiException;
import io.fis.simulacion.mx.client.ApiResponse;
import io.fis.simulacion.mx.client.model.DomicilioPeticion;
import io.fis.simulacion.mx.client.model.PersonaPeticion;
import io.fis.simulacion.mx.client.model.Respuesta;
import okhttp3.OkHttpClient;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ApiTest {
    
    private Logger logger = LoggerFactory.getLogger(ApiTest.class.getName());
    private final FinancialInclusionScoreSimulacinApi api = new FinancialInclusionScoreSimulacinApi();
    private ApiClient apiClient = null;    
    
    @Before()
    public void setUp() {
        this.apiClient = api.getApiClient();
        this.apiClient.setBasePath("the_url");
        OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
                .readTimeout(30, TimeUnit.SECONDS)
                .build();
        apiClient.setHttpClient(okHttpClient);
    }    
    
    @Test
    public void getReporteTest() throws ApiException {
        
        String xApiKey = "your_api_key";
        Integer estatusOK = 200;
        Integer estatusNoContent = 204;
        
        PersonaPeticion persona = null;
        DomicilioPeticion domicilio = null;
        
        try {
            
            persona = new PersonaPeticion();
            domicilio = new DomicilioPeticion();
                        
            persona.setApellidoPaterno("OLIVOS");
            persona.setApellidoMaterno("JIMENEZ");
            persona.setApellidoAdicional(null);
            persona.setPrimerNombre("JUAN");
            persona.setSegundoNombre(null);
            persona.setFechaNacimiento("1966-05-13");
            persona.setRFC("CUPU800825569");
            persona.setCURP(null);
            persona.setNacionalidad(null);
            persona.setResidencia(null);
            persona.setEstadoCivil(null);
            persona.setSexo(null);
            persona.setNumeroDependientes(null);
            persona.setFechaDefuncion(null);
            
            domicilio.setDireccion("san joaquin");
            domicilio.setColoniaPoblacion("el arenal");
            domicilio.setDelegacionMunicipio("iztapalapa");
            domicilio.setCiudad("mexico");
            domicilio.setEstado(CatalogoEstados.CDMX);
            domicilio.setCP("12345");
            domicilio.setFechaResidencia(null);
            domicilio.setNumeroTelefono(null);
            domicilio.setTipoDomicilio(null);
            domicilio.setTipoAsentamiento(null);
            
            persona.setDomicilio(domicilio);
            
            ApiResponse<?>  response = api.getGenericScoreNoHitDG(xApiKey, persona);
            
            Assert.assertTrue(estatusOK.equals(response.getStatusCode()));
            
            if(estatusOK.equals(response.getStatusCode())) {
                Respuesta responseOK = (Respuesta) response.getData();
                logger.info(responseOK.toString());
            }

        } catch (ApiException e) {
            if(!estatusNoContent.equals(e.getCode())) {
                logger.info(e.getResponseBody());
            }
            Assert.assertTrue(estatusOK.equals(e.getCode()));           
        }
        
    }
    
}
