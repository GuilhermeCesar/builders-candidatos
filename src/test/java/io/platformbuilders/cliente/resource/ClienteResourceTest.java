package io.platformbuilders.cliente.resource;

import io.platformbuilders.cliente.dto.ClienteDTO;
import io.platformbuilders.cliente.enumeration.Sexo;
import io.platformbuilders.cliente.service.ClienteService;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.data.domain.PageImpl;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.List;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.mockito.ArgumentMatchers.any;

@Slf4j
@ExtendWith(SpringExtension.class)
@ActiveProfiles({"default", "test"})
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ClienteResourceTest {

    @Value("${test.api.v1.basePath}")
    private String basePath;

    @MockBean
    private ClienteService clienteService;

    @LocalServerPort
    private Integer portServer;

    @Test
    void buscarClientes() {
        final var clienteDTOS = List.of(
                new ClienteDTO(1, "Guilherme", "01961770067", LocalDate.of(2008, 11, 14), Sexo.MASCULINO),
                new ClienteDTO(2, "Joãozinho", "54312324018", LocalDate.of(2008, 11, 14), Sexo.MASCULINO)
        );

        Mockito.when(this.clienteService.buscar(any(), any()))
                .thenReturn(new PageImpl(clienteDTOS));

        given()
                .get("http://localhost:" + this.portServer + this.basePath)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body(matchesJsonSchemaInClasspath("json-schema/pageable.json"));
    }
}
