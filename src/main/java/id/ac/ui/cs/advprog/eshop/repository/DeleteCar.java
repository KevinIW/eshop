package id.ac.ui.cs.advprog.eshop.repository;

public class DeleteCar {
    private CarRepository carRepository;

    public DeleteCar(CarRepository carRepository) {
        this.carRepository = carRepository;
    }


    public void deleteCar(String carId) {
        carRepository.carData.removeIf(car -> car.getCarId().equals(carId));
    }

}