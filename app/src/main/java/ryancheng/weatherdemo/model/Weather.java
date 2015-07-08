package ryancheng.weatherdemo.model;

/**
 * Created by 瑞 on 2015/7/6.
 */
public class Weather {

    /**
     * errNum : 0
     * errMsg : success
     * retData : {"WS":"微风(<10m/h)","altitude":"33","postCode":"100000","l_tmp":"22","date":"15-07-06","city":"北京","citycode":"101010100","time":"11:00","h_tmp":"31","WD":"无持续风向","sunset":"19:46","weather":"多云","temp":"31","longitude":116.391,"sunrise":"04:52","latitude":39.904,"pinyin":"beijing"}
     */
    private int errNum;
    private String errMsg;
    private RetDataEntity retData;

    public void setErrNum(int errNum) {
        this.errNum = errNum;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public void setRetData(RetDataEntity retData) {
        this.retData = retData;
    }

    public int getErrNum() {
        return errNum;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public RetDataEntity getRetData() {
        return retData;
    }

    public class RetDataEntity {
        /**
         * WS : 微风(<10m/h)
         * altitude : 33
         * postCode : 100000
         * l_tmp : 22
         * date : 15-07-06
         * city : 北京
         * citycode : 101010100
         * time : 11:00
         * h_tmp : 31
         * WD : 无持续风向
         * sunset : 19:46
         * weather : 多云
         * temp : 31
         * longitude : 116.391
         * sunrise : 04:52
         * latitude : 39.904
         * pinyin : beijing
         */
        private String WS;
        private String altitude;
        private String postCode;
        private String l_tmp;
        private String date;
        private String city;
        private String citycode;
        private String time;
        private String h_tmp;
        private String WD;
        private String sunset;
        private String weather;
        private String temp;
        private double longitude;
        private String sunrise;
        private double latitude;
        private String pinyin;

        public void setWS(String WS) {
            this.WS = WS;
        }

        public void setAltitude(String altitude) {
            this.altitude = altitude;
        }

        public void setPostCode(String postCode) {
            this.postCode = postCode;
        }

        public void setL_tmp(String l_tmp) {
            this.l_tmp = l_tmp;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public void setCitycode(String citycode) {
            this.citycode = citycode;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public void setH_tmp(String h_tmp) {
            this.h_tmp = h_tmp;
        }

        public void setWD(String WD) {
            this.WD = WD;
        }

        public void setSunset(String sunset) {
            this.sunset = sunset;
        }

        public void setWeather(String weather) {
            this.weather = weather;
        }

        public void setTemp(String temp) {
            this.temp = temp;
        }

        public void setLongitude(double longitude) {
            this.longitude = longitude;
        }

        public void setSunrise(String sunrise) {
            this.sunrise = sunrise;
        }

        public void setLatitude(double latitude) {
            this.latitude = latitude;
        }

        public void setPinyin(String pinyin) {
            this.pinyin = pinyin;
        }

        public String getWS() {
            return WS;
        }

        public String getAltitude() {
            return altitude;
        }

        public String getPostCode() {
            return postCode;
        }

        public String getL_tmp() {
            return l_tmp;
        }

        public String getDate() {
            return date;
        }

        public String getCity() {
            return city;
        }

        public String getCitycode() {
            return citycode;
        }

        public String getTime() {
            return time;
        }

        public String getH_tmp() {
            return h_tmp;
        }

        public String getWD() {
            return WD;
        }

        public String getSunset() {
            return sunset;
        }

        public String getWeather() {
            return weather;
        }

        public String getTemp() {
            return temp;
        }

        public double getLongitude() {
            return longitude;
        }

        public String getSunrise() {
            return sunrise;
        }

        public double getLatitude() {
            return latitude;
        }

        public String getPinyin() {
            return pinyin;
        }

        @Override
        public String toString() {
            return "RetDataEntity{" +
                    "WS='" + WS + '\'' +
                    ", altitude='" + altitude + '\'' +
                    ", postCode='" + postCode + '\'' +
                    ", l_tmp='" + l_tmp + '\'' +
                    ", date='" + date + '\'' +
                    ", city='" + city + '\'' +
                    ", citycode='" + citycode + '\'' +
                    ", time='" + time + '\'' +
                    ", h_tmp='" + h_tmp + '\'' +
                    ", WD='" + WD + '\'' +
                    ", sunset='" + sunset + '\'' +
                    ", weather='" + weather + '\'' +
                    ", temp='" + temp + '\'' +
                    ", longitude=" + longitude +
                    ", sunrise='" + sunrise + '\'' +
                    ", latitude=" + latitude +
                    ", pinyin='" + pinyin + '\'' +
                    '}';
        }
    }
}
