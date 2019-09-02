package models;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class HealthCheckLogic {
    public void execute(Health health) {

        // BMIの計算
        double height = Double.parseDouble(health.getHeight());
        double weight = Double.parseDouble(health.getWeight());
        double bmi = 10000 * (weight / height / height);

        BigDecimal bdbmi =  new BigDecimal(bmi);
        bdbmi = bdbmi.setScale(2, RoundingMode.HALF_UP);
        health.setBmi(bdbmi.doubleValue());

        // BMIの判定
        String bodyType;
        if (bmi < 16.00) {
            bodyType = "痩せすぎ";
        } else if (16.00 <= bmi && bmi < 18.50) {
            bodyType = "痩せぎみ";
        } else if (18.50 <= bmi && bmi < 25.00) {
            bodyType = "普通";
        } else if (25.00 <= bmi && bmi < 30.00) {
            bodyType = "肥満度1";
        } else if (30.00 <= bmi && bmi < 35.00) {
            bodyType = "肥満度2";
        } else if (35.00 <= bmi && bmi < 40.00) {
            bodyType = "肥満度3";
        } else {
            bodyType = "肥満度4";
        }
        health.setBodyType(bodyType);

        // 体脂肪量の判定
        int age = Integer.parseInt(health.getAge());
        String gender_flag = health.getGender_flag();
        String body_fat;
        // 未入力の場合
        if (health.getFat_percentage() == null || health.getFat_percentage().equals("")) {
            body_fat = "判定できません";
        // 入力値ありの場合
        } else {
            double fat_percentage = Double.parseDouble(health.getFat_percentage());
            // 男性の場合
            if (18 <= age && age <= 59 && gender_flag.equals("0") && 0 < fat_percentage && fat_percentage <= 10) {
                body_fat = "かなり低い（適性体脂肪率は「11～21%」です）";
            } else if (18 <= age && age <= 59 && gender_flag.equals("0") && 11 <= fat_percentage && fat_percentage <= 16) {
                body_fat = "標準-（適性体脂肪率は「11～21%」です）";
            } else if (18 <= age && age <= 59 && gender_flag.equals("0") && 17 <= fat_percentage && fat_percentage <= 21) {
                body_fat = "標準+（適性体脂肪率は「11～21%」です）";
            } else if (18 <= age && age <= 59 && gender_flag.equals("0") && 22 <= fat_percentage && fat_percentage <= 26) {
                body_fat = "高い（適性体脂肪率は「11～21%」です）";
            } else if (18 <= age && age <= 59 && gender_flag.equals("0") && 27 <= fat_percentage) {
                body_fat = "かなり高い（適性体脂肪率は「11～21%」です）";
            } else if (60 <= age && gender_flag.equals("0") && fat_percentage <= 13) {
                body_fat = "かなり低い（適性体脂肪率は「14～24%」です）";
            } else if (60 <= age && gender_flag.equals("0") && 14 <= fat_percentage && fat_percentage <= 19) {
                body_fat = "標準-（適性体脂肪率は「14～24%」です）";
            } else if (60 <= age && gender_flag.equals("0") && 20 <= fat_percentage && fat_percentage <= 24) {
                body_fat = "標準+（適性体脂肪率は「14～24%」です）";
            } else if (60 <= age && gender_flag.equals("0") && 25 <= fat_percentage && fat_percentage <= 29) {
                body_fat = "高い（適性体脂肪率は「14～24%」です）";
            } else if (60 <= age && gender_flag.equals("0") && 30 <= fat_percentage) {
                body_fat = "かなり高い（適性体脂肪率は「14～24%」です）";
            // 女性の場合
            } else if (18 <= age && age <= 59 && gender_flag.equals("1") && 0 < fat_percentage && fat_percentage <= 20) {
                body_fat = "かなり低い（適性体脂肪率は「21～34%」です）";
            } else if (18 <= age && age <= 59 && gender_flag.equals("1") && 21 <= fat_percentage && fat_percentage <= 27) {
                body_fat = "標準-（適性体脂肪率は「21～34%」です）";
            } else if (18 <= age && age <= 59 && gender_flag.equals("1") && 28 <= fat_percentage && fat_percentage <= 34) {
                body_fat = "標準+（適性体脂肪率は「21～34%」です）";
            } else if (18 <= age && age <= 59 && gender_flag.equals("1") && 35 <= fat_percentage && fat_percentage <= 39) {
                body_fat = "高い（適性体脂肪率は「21～34%」です）";
            } else if (18 <= age && age <= 59 && gender_flag.equals("1") && 40 <= fat_percentage) {
                body_fat = "かなり高い（適性体脂肪率は「21～34%」です）";
            } else if (60 <= age && gender_flag.equals("1") && fat_percentage <= 22) {
                body_fat = "かなり低い（適性体脂肪率は「23～36%」です）";
            } else if (60 <= age && gender_flag.equals("1") && 23 <= fat_percentage && fat_percentage <= 29) {
                body_fat = "標準-（適性体脂肪率は「23～36%」です）";
            } else if (60 <= age && gender_flag.equals("1") && 30 <= fat_percentage && fat_percentage <= 36) {
                body_fat = "標準+（適性体脂肪率は「23～36%」です）";
            } else if (60 <= age && gender_flag.equals("1") && 37 <= fat_percentage && fat_percentage <= 41) {
                body_fat = "高い（適性体脂肪率は「23～36%」です）";
            } else if (60 <= age && gender_flag.equals("1") && 42 <= fat_percentage) {
                body_fat = "かなり高い（適性体脂肪率は「23～36%」です）";
            } else if (age < 18) {
                body_fat = "18歳未満の方は誤差が大きいため測定できません。";
            } else {
                body_fat = "判定できません";
            }
        }
        health.setBody_fat(body_fat);

        // メタボリック判定
        String metabo;
        // 未入力の場合
        if (health.getWaist() == null || health.getWaist().equals("")) {
            metabo = "判定できません";
        // 入力値ありの場合
        } else {
            double waist = Double.parseDouble(health.getWaist());
            if (gender_flag.equals("0") && 0 < waist && waist < 85) {
                metabo = "メタボリックではありません";
            } else if (gender_flag.equals("0") && 85 <= waist) {
                metabo = "メタボリックです";
            } else if (gender_flag.equals("1") && waist < 90) {
                metabo = "メタボリックではありません";
            } else if (gender_flag.equals("1") && 90 <= waist) {
                metabo = "メタボリックです";
            } else {
                metabo = "判定できません";
            }
        }
        health.setMetabo(metabo);

        // 必要栄養素量の計算
        String activity = health.getActivity();
        // 炭水化物量
        double carbo = 0;
        // 年齢が18～59歳までの場合
        if (18 <= age && age <= 59 && bmi <= 24.99 && activity.equals("low")) {
            carbo = weight * 6.5;
        } else if (18 <= age && age <= 59 && 25.00 <= bmi && bmi <= 29.99 && activity.equals("low")) {
            carbo = weight * 5;
        } else if (18 <= age && age <= 59 && 30.00 <= bmi && bmi <= 34.99 && activity.equals("low")) {
            carbo = weight * 4;
        } else if (18 <= age && age <= 59 && 35.00 <= bmi && bmi <= 39.99 && activity.equals("low")) {
            carbo = weight * 4;
        } else if (18 <= age && age <= 59 && 40.00 <= bmi && activity.equals("low")) {
            carbo = weight * 4;
        // 活動量が普通の場合
        } else if (18 <= age && age <= 59 && bmi <= 24.99 && activity.equals("usually")) {
            carbo = weight * 7.5;
        } else if (18 <= age && age <= 59 && 25.00 <= bmi && bmi <= 29.99 && activity.equals("usually")) {
            carbo = weight * 5;
        } else if (18 <= age && age <= 59 && 30.00 <= bmi && bmi <= 34.99 && activity.equals("usually")) {
            carbo = weight * 4;
        } else if (18 <= age && age <= 59 && 35.00 <= bmi && bmi <= 39.99 && activity.equals("usually")) {
            carbo = weight * 3.5;
        } else if (18 <= age && age <= 59 && 40.00 <= bmi && activity.equals("usually")) {
            carbo = weight * 3.5;
        // 活動量が高い場合
        } else if (18 <= age && age <= 59 && bmi <= 24.99 && activity.equals("high")) {
            carbo = weight * 8;
        } else if (18 <= age && age <= 59 && 25.00 <= bmi && bmi <= 29.99 && activity.equals("high")) {
            carbo = weight * 5.5;
        } else if (18 <= age && age <= 59 && 30.00 <= bmi && bmi <= 34.99 && activity.equals("high")) {
            carbo = weight * 4.5;
        } else if (18 <= age && age <= 59 && 35.00 <= bmi && bmi <= 39.99 && activity.equals("high")) {
            carbo = weight * 4;
        } else if (18 <= age && age <= 59 && 40.00 <= bmi && activity.equals("high")) {
            carbo = weight * 3.5;
        // 年齢が60歳以上の場合
        } else if (60 <= age && bmi <= 24.99 && activity.equals("low")){
            carbo = weight * 5;
        } else if (60 <= age && 25.00 <= bmi && bmi <= 29.99 && activity.equals("low")) {
            carbo = weight * 4;
        } else if (60 <= age && 30.00 <= bmi && bmi <= 34.99 && activity.equals("low")) {
            carbo = weight * 3.5;
        } else if (60 <= age && 35.00 <= bmi && bmi <= 39.99 && activity.equals("low")) {
            carbo = weight * 3.5;
        } else if (60 <= age && 40.00 <= bmi && activity.equals("low")) {
            carbo = weight * 3.5;
        // 活動量が普通の場合
        } else if (60 <= age && bmi <= 24.99 && activity.equals("usually")) {
            carbo = weight * 6;
        } else if (60 <= age && 25.00 <= bmi && bmi <= 29.99 && activity.equals("usually")) {
            carbo = weight * 5.5;
        } else if (60 <= age && 30.00 <= bmi && bmi <= 34.99 && activity.equals("usually")) {
            carbo = weight * 4;
        } else if (60 <= age && 35.00 <= bmi && bmi <= 39.99 && activity.equals("usually")) {
            carbo = weight * 3.5;
        } else if (60 <= age && 40.00 <= bmi && activity.equals("usually")) {
            carbo = weight * 3.5;
        // 活動量が高い場合
        } else if (60 <= age && bmi <= 24.99 && activity.equals("high")) {
            carbo = weight * 6.5;
        } else if (60 <= age && 25.00 <= bmi && bmi <= 29.99 && activity.equals("high")) {
            carbo = weight * 5;
        } else if (60 <= age && 30.00 <= bmi && bmi <= 34.99 && activity.equals("high")) {
            carbo = weight * 4.5;
        } else if (60 <= age && 35.00 <= bmi && bmi <= 39.99 && activity.equals("high")) {
            carbo = weight * 4;
        } else if (60 <= age && 40.00 <= bmi && activity.equals("high")) {
            carbo = weight * 3.5;
        } else {
            carbo = 1;
        }
        health.setCarbo(carbo);

        // たんぱく質量
        double protein = 0;
        // 年齢が18～59歳までの場合
        if (18 <= age && age <= 59 && activity.equals("low")) {
            protein = weight;
        } else if (18 <= age && age <= 59 && activity.equals("usually")) {
            protein = weight * 1.5;
        } else if (18 <= age && age <= 59 && activity.equals("high")) {
            protein = weight * 2;
        // 年齢が60歳以上の場合
        } else if (60 <= age && activity.equals("low")) {
            protein = weight * 1;
        } else if (60 <= age && activity.equals("usually")) {
            protein = weight * 1.2;
        } else if (60 <= age && activity.equals("high")) {
            protein = weight * 1.5;
        } else {
            protein = 1;
        }
        health.setProtein(protein);

        // 脂質量
        double fat = 0;
        // 年齢が18～59歳までの場合
        if (18 <= age && age <= 59 && bmi <= 24.99 && activity.equals("low")) {
            fat = weight * 1.2;
        } else if (18 <= age && age <= 59 && 25.00 <= bmi && bmi <= 29.99 && activity.equals("low")) {
            fat = weight;
        } else if (18 <= age && age <= 59 && 30.00 <= bmi && bmi <= 34.99 && activity.equals("low")) {
            fat = weight * 0.8;
        } else if (18 <= age && age <= 59 && 35.00 <= bmi && bmi <= 39.99 && activity.equals("low")) {
            fat = weight * 0.6;
        } else if (18 <= age && age <= 59 && 40.00 <= bmi && activity.equals("low")) {
            fat = weight * 0.5;
        // 活動量が普通の場合
        } else if (18 <= age && age <= 59 && bmi <= 24.99 && activity.equals("usually")) {
            fat = weight * 1.3;
        } else if (18 <= age && age <= 59 && 25.00 <= bmi && bmi <= 29.99 && activity.equals("usually")) {
            fat = weight * 1.1;
        } else if (18 <= age && age <= 59 && 30.00 <= bmi && bmi <= 34.99 && activity.equals("usually")) {
            fat = weight * 0.9;
        } else if (18 <= age && age <= 59 && 35.00 <= bmi && bmi <= 39.99 && activity.equals("usually")) {
            fat = weight * 0.7;
        } else if (18 <= age && age <= 59 && 40.00 <= bmi && activity.equals("usually")) {
            fat = weight * 0.6;
        // 活動量が高い場合
        } else if (18 <= age && age <= 59 && bmi <= 24.99 && activity.equals("high")) {
            fat = weight * 1.4;
        } else if (18 <= age && age <= 59 && 25.00 <= bmi && bmi <= 29.99 && activity.equals("high")) {
            fat = weight * 1.2;
        } else if (18 <= age && age <= 59 && 30.00 <= bmi && bmi <= 34.99 && activity.equals("high")) {
            fat = weight;
        } else if (18 <= age && age <= 59 && 35.00 <= bmi && bmi <= 39.99 && activity.equals("high")) {
            fat = weight * 0.8;
        } else if (18 <= age && age <= 59 && 40.00 <= bmi && activity.equals("high")) {
            fat = weight * 0.7;
        // 年齢が60歳以上の場合
        } else if (60 <= age && bmi <= 24.99 && activity.equals("low")){
            fat = weight;
        } else if (60 <= age && 25.00 <= bmi && bmi <= 29.99 && activity.equals("low")) {
            fat = weight * 0.8;
        } else if (60 <= age && 30.00 <= bmi && bmi <= 34.99 && activity.equals("low")) {
            fat = weight * 0.7;
        } else if (60 <= age && 35.00 <= bmi && bmi <= 39.99 && activity.equals("low")) {
            fat = weight * 0.6;
        } else if (60 <= age && 40.00 <= bmi && activity.equals("low")) {
            fat = weight * 0.5;
        // 活動量が普通の場合
        } else if (60 <= age && bmi <= 24.99 && activity.equals("usually")) {
            fat = weight * 1.1;
        } else if (60 <= age && 25.00 <= bmi && bmi <= 29.99 && activity.equals("usually")) {
            fat = weight * 0.9;
        } else if (60 <= age && 30.00 <= bmi && bmi <= 34.99 && activity.equals("usually")) {
            fat = weight * 0.8;
        } else if (60 <= age && 35.00 <= bmi && bmi <= 39.99 && activity.equals("usually")) {
            fat = weight * 0.6;
        } else if (60 <= age && 40.00 <= bmi && activity.equals("usually")) {
            fat = weight * 0.5;
        // 活動量が高い場合
        } else if (60 <= age && bmi <= 24.99 && activity.equals("high")) {
            fat = weight * 1.2;
        } else if (60 <= age && 25.00 <= bmi && bmi <= 29.99 && activity.equals("high")) {
            fat = weight;
        } else if (60 <= age && 30.00 <= bmi && bmi <= 34.99 && activity.equals("high")) {
            fat = weight * 0.8;
        } else if (60 <= age && 35.00 <= bmi && bmi <= 39.99 && activity.equals("high")) {
            fat = weight * 0.6;
        } else if (60 <= age && 40.00 <= bmi && activity.equals("high")) {
            fat = weight * 0.5;
        } else {
            fat = 1;
        }
        health.setFat(fat);

        // 総カロリー計算
        double calorie = 0;
        calorie = (carbo + protein) * 4 + fat * 9;
        health.setCalorie(calorie);
    }
}
