package use_case.CreateProfile;

import data_access.FileUserDataAccessObject;
import entity.User;
import use_case.cancel.CancelOutputData;
import use_case.login.LoginUserDataAccessInterface;

public class CreateProfileInteractor implements CreateProfileInputBoundary {
    final CreateProfileOutputBoundary createProfilePresenter;
    final FileUserDataAccessObject userDataAccessObject;
    public CreateProfileInteractor(CreateProfileOutputBoundary createProfilePresenter, FileUserDataAccessObject userDataAccessObject){
        this.createProfilePresenter =  createProfilePresenter;
        this.userDataAccessObject = userDataAccessObject;
    }

    @Override
    public void execute(CreateProfileInputData createProfileInputData) {
        User user = userDataAccessObject.get(createProfileInputData.getUsername());
        CreateProfileOutputData outputData = new CreateProfileOutputData(user.getName(), user.getUserDescription());
        createProfilePresenter.prepareSuccessView(outputData);
    }
}
