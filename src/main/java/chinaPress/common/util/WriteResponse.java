package chinaPress.common.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;

import com.fasterxml.jackson.databind.ObjectMapper;

public class WriteResponse {
	private static final ObjectMapper mapper = new ObjectMapper();

	public static void write(HttpServletResponse httpServletResponse, Object object) throws IOException {
		httpServletResponse.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
		PrintWriter out = httpServletResponse.getWriter();
		out.write(mapper.writeValueAsString(object));
		out.flush();
		out.close();
	}
}
