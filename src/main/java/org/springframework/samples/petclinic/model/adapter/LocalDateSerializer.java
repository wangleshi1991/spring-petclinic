package org.springframework.samples.petclinic.model.adapter;

import java.io.IOException;

import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
/**
 * Custom Json serializer for LocalDate
 * @author wangl
 *
 */
public class LocalDateSerializer extends JsonSerializer<LocalDate> {
	private static DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy/MM/dd");

	@Override
	public void serialize(LocalDate value, JsonGenerator gen, SerializerProvider arg2)
			throws IOException, JsonProcessingException {

		gen.writeString(formatter.print(value));
	}
}
