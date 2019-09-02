package validators;

import java.util.ArrayList;
import java.util.List;

import models.Health;

public class HealthValidator {
    public static List<String> validate(Health health) {
        List<String> errors = new ArrayList<String>();

        String age_error = _validateAge(health.getAge());
        if(age_error.equals("") == false) {
            errors.add(age_error);
        }

        String height_error = _validateHeight(health.getHeight());
        if(height_error.equals("") == false) {
            errors.add(height_error);
        }

        String weight_error = _validateWeight(health.getWeight());
        if(weight_error.equals("") == false) {
            errors.add(weight_error);
        }

        String fat_percentage_error = _validateFat_percentage(health.getFat_percentage());
        if(fat_percentage_error.equals("") == false) {
            errors.add(fat_percentage_error);
        }

        String waist_error = _validateWaist(health.getWaist());
        if(waist_error.equals("") == false) {
            errors.add(waist_error);
        }

        return errors;
    }

    private static String _validateAge(String age) {
        if(age == null || age.equals("")) {
            return "年齢を入力してください";
        } else {
            try {
                Integer.parseInt(age);
            } catch(NumberFormatException e) {
                return "年齢は数字で入力してください";
            }
        }
        return "";
    }

    private static String _validateHeight(String height) {
        if(height == null || height.equals("")) {
            return "身長を入力してください";
        } else {
            try {
                Double.parseDouble(height);
            } catch(NumberFormatException e) {
                return "身長は半角数字で入力してください";
            }
        }
        return "";
    }

    private static String _validateWeight(String weight) {
        if(weight == null || weight.equals("")) {
            return "体重を入力してください";
        } else {
            try {
                Double.parseDouble(weight);
            } catch(NumberFormatException e) {
                return "体重は半角数字で入力してください";
            }
        }
        return "";
    }

    private static String _validateFat_percentage(String fat_percentage) {
        if(fat_percentage == null || fat_percentage.equals("")) {
            return "";
        } else {
            try {
                Double.parseDouble(fat_percentage);
            } catch(NumberFormatException e) {
                return "体脂肪率は半角数字で入力してください";
            }
        }
        return "";
    }

    private static String _validateWaist(String waist) {
        if(waist == null || waist.equals("")) {
            return "";
        } else {
            try {
                Double.parseDouble(waist);
            } catch(NumberFormatException e) {
                return "腹囲は半角数字で入力してください";
            }
        }
        return "";
    }

}
