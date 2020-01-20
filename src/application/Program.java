package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner in = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Digite o nome do departamento:");
		String departmentName = in.nextLine();
		System.out.println("Digite os dados do trabalhador:");
		System.out.print("Nome: ");
		String workerName = in.nextLine();
		System.out.print("Experiencia: ");
		String workerLevel = in.nextLine();
		System.out.print("Salario base: ");
		Double baseSalary = in.nextDouble();
		Worker w1 = new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalary, new Department(departmentName));
		
		System.out.println();
		System.out.print("Quantos contratos para esse trabalhador?");
		int contracts = in.nextInt();
		
		for (int i = 1; i <= contracts; i++) {
			System.out.println("Digite os dados do contrato " + i + ": ");
			System.out.print("Data (DD/MM/YYYY)");
			Date date = sdf.parse(in.next());
			System.out.print("Valor por Hora: ");
			double valuePerHour = in.nextDouble();
			System.out.print("Horas trabalhadas: ");
			int hours = in.nextInt();
			HourContract contract = new HourContract(date, valuePerHour, hours);
			w1.addContract(contract);
		}
		
		System.out.println();
		System.out.println("Digite o mês e o ano para calcular a renda (MM/AAAA): ");
		String monthAndYear = in.next();
		int month = Integer.parseInt(monthAndYear.substring(0,2));
		int year = Integer.parseInt(monthAndYear.substring(3));
		
		System.out.println("Nome: " + w1.getName());
		System.out.println("Departamento: "+ w1.getDepartment().getName());
		System.out.println("Renda do mes " + monthAndYear + ": " + String.format("%.2f", w1.income(year, month)));

	}

}
