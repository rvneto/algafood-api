package com.roberto.algafood.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.roberto.algafood.domain.model.Cozinha;
import lombok.Data;
import lombok.NonNull;

import java.util.List;

@Data
@JsonRootName("cozinhas")
public class CozinhasXmlWrapper {

    @NonNull
    @JsonProperty("cozinha")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Cozinha> cozinhas;

}
