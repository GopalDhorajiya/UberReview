CREATE TABLE booking
(
    id             BIGINT AUTO_INCREMENT NOT NULL,
    created_at     datetime              NULL,
    updated_at     datetime              NOT NULL,
    booking_status ENUM( 'SCHEDULE',
        'CANCELLED',
        'CAB_ARRIVED',
        'ASSINGING_DRIVER',
        'IN_RIDE',
        'COMPLETED')         NULL,
    start_time     datetime              NULL,
    end_time       datetime              NULL,
    total_distance BIGINT                NOT NULL,
    driver_id      BIGINT                NULL,
    passenger_id   BIGINT                NULL,
    CONSTRAINT pk_booking PRIMARY KEY (id)
);

CREATE TABLE driver
(
    id             BIGINT AUTO_INCREMENT NOT NULL,
    created_at     datetime              NULL,
    updated_at     datetime              NOT NULL,
    name           VARCHAR(255)          NULL,
    license_number VARCHAR(255)          NOT NULL,
    address        VARCHAR(255)          NULL,
    CONSTRAINT pk_driver PRIMARY KEY (id)
);

CREATE TABLE passenger
(
    id         BIGINT AUTO_INCREMENT NOT NULL,
    created_at datetime              NULL,
    updated_at datetime              NOT NULL,
    name       VARCHAR(255)          NULL,
    CONSTRAINT pk_passenger PRIMARY KEY (id)
);

CREATE TABLE review
(
    id         BIGINT AUTO_INCREMENT NOT NULL,
    created_at datetime              NULL,
    updated_at datetime              NOT NULL,
    content    VARCHAR(255)          NULL,
    rating     DOUBLE                NOT NULL,
    booking_id BIGINT                NOT NULL,
    CONSTRAINT pk_review PRIMARY KEY (id)
);

ALTER TABLE driver
    ADD CONSTRAINT uc_driver_licensenumber UNIQUE (license_number);

ALTER TABLE review
    ADD CONSTRAINT uc_review_booking UNIQUE (booking_id);

ALTER TABLE booking
    ADD CONSTRAINT FK_BOOKING_ON_DRIVER FOREIGN KEY (driver_id) REFERENCES driver (id);

ALTER TABLE booking
    ADD CONSTRAINT FK_BOOKING_ON_PASSENGER FOREIGN KEY (passenger_id) REFERENCES passenger (id);

ALTER TABLE review
    ADD CONSTRAINT FK_REVIEW_ON_BOOKING FOREIGN KEY (booking_id) REFERENCES booking (id);