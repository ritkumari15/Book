package com.Book.dto;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.Date;
import java.util.Set;
import java.util.UUID;

import javax.annotation.Nullable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@JsonSerialize
@JsonDeserialize(as = ImmutableBookDto.class)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Value.Immutable
public interface BookDto {
	
	@Nullable
	Long getId();

	@NotNull
	String getName();

	@Nullable
	Set<Long> getStores();

}
