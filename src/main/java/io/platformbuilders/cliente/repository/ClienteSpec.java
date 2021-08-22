package io.platformbuilders.cliente.repository;

import io.platformbuilders.cliente.entity.Cliente;
import io.platformbuilders.cliente.enumeration.Sexo;
import lombok.Builder;
import lombok.Value;
import lombok.With;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Value
@With
@Builder
public class ClienteSpec implements Specification<Cliente> {

    @Builder.Default
    private transient Optional<Long> idOptional = Optional.empty();
    @Builder.Default
    private transient Optional<String> nomeOptional = Optional.empty();
    @Builder.Default
    private transient Optional<String> cpfOptional = Optional.empty();
    @Builder.Default
    private transient Optional<LocalDate> dataNascimentoOptional = Optional.empty();
    @Builder.Default
    private transient Optional<Sexo> sexoOptional = Optional.empty();
    @Builder.Default
    private transient Optional<Integer> idadeOptional = Optional.empty();


    @Override
    public Predicate toPredicate(Root<Cliente> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder builder) {
        List<Predicate> predcs = new ArrayList<>();

        this.idOptional.ifPresent(id -> predcs.add(builder.equal(root.get("id"), id)));
        this.nomeOptional.ifPresent(nome -> predcs.add(builder.equal(root.get("nome"), nome)));
        this.cpfOptional.ifPresent(cpf -> predcs.add(builder.equal(root.get("cpf"), cpf)));
        this.dataNascimentoOptional.ifPresent(dataNascimento -> predcs.add(builder.equal(root.get("dataNascimento"), dataNascimento)));
        this.sexoOptional.ifPresent(sexo -> predcs.add(builder.equal(root.get("sexo"), sexo)));
        this.idadeOptional.ifPresent(idade -> {
            final var firstDayYear = LocalDate.now().minusYears(idade).with(TemporalAdjusters.firstDayOfYear());
            final var lastDayYear = LocalDate.now().minusYears(idade).with(TemporalAdjusters.lastDayOfYear());
            predcs.add(builder.between(root.get("dataNascimento"), firstDayYear, lastDayYear));
        });

        return builder.and(predcs.toArray(new Predicate[predcs.size()]));
    }
}
