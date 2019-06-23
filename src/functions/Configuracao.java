package functions;

public class Configuracao {

	private double multa;
	private int diasAluno;
	private int diasProf;
	private int diasTecnico;

	public Configuracao(double multa, int diasAluno, int diasProf, int diasTecnico) {
		this.setMulta(multa);
		this.setDiasAluno(diasAluno);
		this.setDiasProf(diasProf);
		this.setDiasTec(diasTecnico);

	}

	public int getDiasProf() {
		return diasProf;
	}

	public void setDiasProf(int diasProf) {
		this.diasProf = diasProf;
	}

	public int getDiasTec() {
		return diasTecnico;
	}

	public void setDiasTec(int diasTec) {
		this.diasTecnico = diasTec;
	}

	public int getDiasAluno() {
		return diasAluno;
	}

	public void setDiasAluno(int diasAluno) {
		this.diasAluno = diasAluno;
	}

	public double getMulta() {
		return multa;
	}

	public void setMulta(double multa) {
		this.multa = multa;
	}

}