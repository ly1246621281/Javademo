package Factor;

 class Testsdfaas implements Provider{

	public Sender produce() {
		return new SmsSender();
	}
}
