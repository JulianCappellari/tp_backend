package tp.tp_backend.controllers.alquileresControllers;



import tp.tp_backend.servicies.alquileres.AlquileresService;

public class AlquileresControllerBuilder {
    private AlquileresService alquileresService;

    public AlquileresControllerBuilder setAlquileresService(AlquileresService alquileresService) {
        this.alquileresService = alquileresService;
        return this;
    }

    public AlquileresController createAlquileresController() {
        return new AlquileresController(alquileresService);
    }
}
