
CREATE DATABASE IF NOT EXISTS estoque_ads;

USE estoque_ads;

-- Cria a tabela de produtos
CREATE TABLE IF NOT EXISTS produtos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    categoria VARCHAR(50),
    preco DECIMAL(10, 2) NOT NULL
);

-- Limpa dados antigos e insere novos para teste
TRUNCATE TABLE produtos;

INSERT INTO produtos (nome, categoria, preco) VALUES 
('Notebook Dell G15', 'Informática', 5200.00),
('Mouse Logitech', 'Periféricos', 120.00),
('Monitor 24pol', 'Telas', 850.00),
('Teclado Mecânico', 'Periféricos', 250.00);