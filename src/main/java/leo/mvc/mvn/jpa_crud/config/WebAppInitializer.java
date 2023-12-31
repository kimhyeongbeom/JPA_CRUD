package leo.mvc.mvn.jpa_crud.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletRegistration;

public class WebAppInitializer implements WebApplicationInitializer{

    @Override
    public void onStartup(ServletContext container) {
      // Create the dispatcher servlet's Spring application context
      AnnotationConfigWebApplicationContext dispatcherContext =
        new AnnotationConfigWebApplicationContext();
      dispatcherContext.register(SpringMvcConfiguration.class);

      // Register and map the dispatcher servlet
      ServletRegistration.Dynamic dispatcher =
        container.addServlet("dispatcher", new DispatcherServlet(dispatcherContext));
      dispatcher.setLoadOnStartup(1);
      dispatcher.addMapping("/");
    }

}
