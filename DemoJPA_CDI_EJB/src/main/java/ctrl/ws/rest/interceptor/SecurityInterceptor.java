package ctrl.ws.rest.interceptor;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.Provider;

@Provider
@PreMatching
public class SecurityInterceptor implements ContainerRequestFilter {

	@Override
	public void filter(ContainerRequestContext reqCtx) throws IOException {
		String secure = reqCtx.getHeaderString("Xtra-Secure2022");
//		if(secure == null || !secure.equals("123455")) {
//			ResponseBuilder respBuilder = Response.status(Status.EXPECTATION_FAILED);
//			
//			reqCtx.abortWith(respBuilder.build());
//		}
	}

}
