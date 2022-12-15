package ru.maxryazan.e_shop.model.modelStates;

public enum ProductStatus {
    AVAILABLE {
        @Override
        public String toString() {
            return "В наличии";
        }
    },
    NOT_AVAILABLE {
        @Override
        public String toString() {
            return "Нет в наличии";
        }
    }
}
