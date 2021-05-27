--INSERT INTO `empresa` (`id`, `cnpj`, `data_atualizacao`, `data_criacao`, `razao_social`) VALUES (NULL, '82198127000121', CURRENT_DATE(), CURRENT_DATE(), 'Splopes');

--INSERT INTO `funcionario` (`id`, `cpf`, `data_atualizacao`, `data_criacao`, `email`, `nome`, `perfil`, `qtd_horas_almoco`, `qtd_horas_trabalho_dia`, `senha`,
--`valor_hora`, `empresa_id`) VALUES (NULL, '16248890935', CURRENT_DATE(), CURRENT_DATE(), 'admin@admin.com', 'ADMIN', 'ROLE_ADMIN', NULL, NULL,
--'$2a$10$OYYGj4v3CIi0m4nUSxW0Zu6GZIxtAq/WQkDcrCbl8Sja7N3rugRBS', NULL, (SELECT `id` FROM `empresa` WHERE `cnpj` = '82198127000121'));

INSERT INTO `empresa` (`id`, `cnpj`, `data_atualizacao`, `data_criacao`, `razao_social`)
VALUES (NULL, '82198127000121', CURRENT_DATE(), CURRENT_DATE(), 'Kazale IT');

INSERT INTO `funcionario` (`id`, `cpf`, `data_atualizacao`, `data_criacao`, `email`, `nome`,
`perfil`, `qtd_horas_almoco`, `qtd_horas_trabalho_dia`, `senha`, `valor_hora`, `empresa_id`)
VALUES (NULL, '16248890935', CURRENT_DATE(), CURRENT_DATE(), 'admin@admin.com', 'ADMIN', 'ROLE_ADMIN', NULL, NULL,
'123456', NULL, (SELECT `id` FROM `empresa` WHERE `cnpj` = '82198127000121'));