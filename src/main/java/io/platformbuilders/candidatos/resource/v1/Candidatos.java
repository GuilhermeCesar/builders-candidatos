package io.platformbuilders.candidatos.resource.v1;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/v1/test", produces = APPLICATION_JSON_VALUE)
//@Api(tags = SwaggerConfig.SwaggerTags.PLAN)
public class Candidatos {

//    @Qualifier("planServiceImpl")
//    private final PlanService planFacade;

    @GetMapping
//    @ApiOperation(value = "${refinancing.resource.plan}", response = RefinancingPlansDTO.class)
    @ResponseStatus(HttpStatus.OK)
    public String getPlan() {
        return "Pegati";
    }
}
