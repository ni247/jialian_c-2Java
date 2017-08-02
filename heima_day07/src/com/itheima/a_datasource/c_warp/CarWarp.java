package com.itheima.a_datasource.c_warp;

public class CarWarp implements Car {
	private Car car;

	public CarWarp(Car car) {
		this.car = car;
	}

	@Override
	public void run() {
		car.run();

	}

	@Override
	public void stop() {
		car.stop();

	}

}
