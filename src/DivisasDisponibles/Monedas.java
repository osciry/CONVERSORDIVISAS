package DivisasDisponibles;

public class Monedas {
        private String base_code;
        private String target_code;
        private double conversion_rate;

        public String getBaseCode() {
            return base_code;
        }

        public void setBaseCode(String base_code) {
            this.base_code = base_code;
        }

        public String getTargetCode() {
            return target_code;
        }

        public void setTargetCode(String target_code) {
            this.target_code = target_code;
        }

        public double getConversionRate() {
            return conversion_rate;
        }

        public void setConversionRate(double conversion_rate) {
            this.conversion_rate = conversion_rate;
        }
    }
