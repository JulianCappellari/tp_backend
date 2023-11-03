package tp.tp_backend.controllers.estacionesControllers;


import tp.tp_backend.servicies.estaciones.EstacionesService;

public class EstacionesControllerBuilder {
    private EstacionesService estacionesService;

    public EstacionesControllerBuilder setEstacionesService(EstacionesService estacionesService) {
        this.estacionesService = estacionesService;
        return this;
    }

    public EstacionesController createEstacionesController() {
        return new EstacionesController(estacionesService);
    }
}
