package ru.rzn.sbt.javaschool.basics;

import java.util.Objects;

public class LethalWeapon {
	public String color;
	private int roundsLeft;
	private Double power;
	private long serial;

	private static long nextSerial = 0;

	public long getSerial() {
		return serial;
	}

	public Double getPower() {
		return power;
	}

	public void setPover(Double power) {
		this.power = power;
	}

	public void reload(int count) {
		roundsLeft += count;
	}

	public void pewPew() {
		roundsLeft -= 2;
	}

	public LethalWeapon() {
		this.serial = nextSerial;
		nextSerial++;
	}

	public LethalWeapon(String color, Double power, int roundsLeft) {
		this();
		this.color = color;
		this.power = power;
		this.roundsLeft = roundsLeft;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		LethalWeapon that = (LethalWeapon) o;
		return (this.roundsLeft == that.roundsLeft &&
				this.color.equals(that.color) &&
				this.power.equals(that.power));
	}

	@Override
	public int hashCode() {
		return Objects.hash(color, roundsLeft, power);
	}
}
