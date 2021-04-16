package domains.forms;

import framework.domain.forms.BaseForm;

public class UserPage extends BaseForm {

    public String checkOpenedUrl() {
        return getURL();
    }
}
