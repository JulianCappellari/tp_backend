package tp.tp_backend.controllers.tarifasControllers;

import tp.tp_backend.servicies.tarifas.TarifasService;

public class TarifasControllerBuilder {
    private TarifasService tarifasService;

    public TarifasControllerBuilder setTarifasService(TarifasService tarifasService) {
        this.tarifasService = tarifasService;
        return this;
    }

    public TarifasController createTarifasController() {
        return new TarifasController(tarifasService);
    }
}
