package id.ac.ui.cs.advprog.eshop.repository;
import id.ac.ui.cs.advprog.eshop.model.Car;

public class UpdateCar {
    private CarRepository carRepository;

    public UpdateCar(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public Car updateCar(String carId, Car updateCar) {
        for (int i = 0; i < carRepository.carData.size(); i++) {
            Car car = carRepository.carData.get(i);
            if (car.getCarId().equals(carId)) {
                car.setCarName(updateCar.getCarName());
                car.setCarColor(updateCar.getCarColor());
                car.setCarQuantity(updateCar.getCarQuantity());
                return car;
            }
        }
        return null;
    }
}