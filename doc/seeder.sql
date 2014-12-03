INSERT INTO `backenduser` (`ID`, `EMAIL`, `PASSWORD`, `USERNAME`, `ENABLED`, `role_id`) VALUES
(1, 'kriss@test.com', '$2a$10$KrK8HeZcGDbUUDNdOlBnw.0e1qxl5g36WQRHwwEjXYNmaSoO4kfCK', 'kriss', 1, 1);

INSERT INTO `role` (`id`, `name`) VALUES
(1, 'administrator'),
(2, 'member');

INSERT INTO `user` (`id`, `created`, `email`, `firstname`, `lastname`, `modified`, `password`, `timezone`, `type`, `company_id`, `role_id`) VALUES
(1, NULL, 'kriss@test.com', 'Kriss', 'Kross', NULL, '$2a$10$KrK8HeZcGDbUUDNdOlBnw.0e1qxl5g36WQRHwwEjXYNmaSoO4kfCK', NULL, NULL, NULL, 1);