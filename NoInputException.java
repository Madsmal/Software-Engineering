package project.app;

public class NoInputException extends Exception {

	public NoInputException(String errorMsg) {
		super(errorMsg);
	}
	public String getOperation() {
		if (getMessage().equals("Please specify project name, description and starting date")) {
			return "Create project";
		} else if (getMessage().equals("Please specify a valid employee")) {
			return "Add employee";
		}else if (getMessage().equals("Please select a valid employee")) {
			return "Assign employee";
		} else if (getMessage().equals("Please set valid leader")) {
				return "Set leader";
		} else if (getMessage().equals("The leader has already been set")){
			return "Set leader";
		} else {
			return "Create activity";
		}

	}
}
