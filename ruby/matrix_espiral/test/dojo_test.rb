# encoding: utf-8
require '../lib/espiral'

require 'minitest/spec'
require 'minitest/autorun'


# Problema da Matriz Espiral feito a partir do site http://dojopuzzles.com/problemas/exibe/matriz-espiral/
#
# Dado um número de colunas e um número de linhas, retornar uma matriz em espiral de fora para dentro no sentido horário.
# Variação do problema: retorne a espiral no sentido anti-horário.


describe Espiral do

  before do
  end

  describe "matrix de 1 linha" do

    it "deve receber 2 numeros e retornar linhas e colunas" do
      espiral = Espiral.new 3, 4
      assert_equal 3, espiral.coluna
      assert_equal 4, espiral.linha
    end

    it "deve retornar 1 para posicao 1, 1 de espiral 1, 1" do
      espiral = Espiral.new 1, 1
      assert_equal 1, espiral.pos(1, 1)
    end

    it "uma espiral de 5, 1 começa com 1 e termina com 5" do
      espiral = Espiral.new 5, 1
      assert_equal 1, espiral.pos(1, 1)
      assert_equal 5, espiral.pos(5, 1)
    end

    it "uma espiral 1, 5 começa com 1 e termina com 5" do
      espiral = Espiral.new 1, 5
      assert_equal 1, espiral.pos(1,1)
      assert_equal 5, espiral.pos(1,5)
    end

  end

  describe "matrix de 2 linhas" do
    it "uma espiral 2, 2 deve retornar a matriz:
      1 2
      4 3
    " do
        espiral = Espiral.new 2, 2
        assert_equal 1, espiral.pos(1,1)
        assert_equal 2, espiral.pos(2,1)
        assert_equal 4, espiral.pos(1,2)
        assert_equal 3, espiral.pos(2,2)
      end

    it "uma espiral 3, 2 deve retornar a matriz:
      1 2 3
      6 5 4  " do
        espiral = Espiral.new 3, 2
        assert_equal 1, espiral.pos(1,1)
        assert_equal 2, espiral.pos(2,1)
        assert_equal 3, espiral.pos(3,1)
        assert_equal 6, espiral.pos(1,2)
        assert_equal 5, espiral.pos(2,2)
        assert_equal 4, espiral.pos(3,2)
    end
  end

  describe "matrix de 3 linhas" do
    it "uma espiral 2, 3 deve retornar a matriz:
      1 2
      6 3
      5 4" do
        espiral = Espiral.new 2, 3
        assert_equal 1, espiral.pos(1,1)
        assert_equal 2, espiral.pos(2,1)
        assert_equal 6, espiral.pos(1,2)
        assert_equal 3, espiral.pos(2,2)
        assert_equal 5, espiral.pos(1,3)
        assert_equal 4, espiral.pos(2,3)
    end

    it "uma espiral 3, 3 deve retornar a matriz:
      1 2 3
      8 9 4
      7 6 5" do
        espiral = Espiral.new 3, 3
        assert_equal 1, espiral.pos(1,1)
        assert_equal 2, espiral.pos(2,1)
        assert_equal 3, espiral.pos(3,1)
        assert_equal 8, espiral.pos(1,2)
        assert_equal 9, espiral.pos(2,2)
        assert_equal 4, espiral.pos(3,2)
        assert_equal 7, espiral.pos(1,3)
        assert_equal 6, espiral.pos(2,3)
        assert_equal 5, espiral.pos(3,3)
    end
  end

  describe "matrix de 4 linhas" do
    it "uma espiral 2, 4 deve retornar a matriz:
      1 2
      8 3
      7 4
      6 5" do
        espiral = Espiral.new 2, 4
        assert_equal 1, espiral.pos(1,1)
        assert_equal 2, espiral.pos(2,1)
        assert_equal 8, espiral.pos(1,2)
        assert_equal 3, espiral.pos(2,2)
        assert_equal 7, espiral.pos(1,3)
        assert_equal 4, espiral.pos(2,3)
        assert_equal 6, espiral.pos(1,4)
        assert_equal 5, espiral.pos(2,4)
    end
    it "uma espiral 4, 4 deve retornar a matriz:
       1  2  3 4
      12 13 14 5
      11 16 15 6
      10  9  8 7" do
        espiral = Espiral.new 4, 4
        assert_equal 1, espiral.pos(1,1)
        assert_equal 2, espiral.pos(2,1)
        assert_equal 3, espiral.pos(3,1)
        assert_equal 4, espiral.pos(4,1)
        assert_equal 12, espiral.pos(1,2)
        assert_equal 13, espiral.pos(2,2)
        assert_equal 14, espiral.pos(3,2)
        assert_equal 5, espiral.pos(4,2)
        assert_equal 11, espiral.pos(1,3)
        assert_equal 16, espiral.pos(2,3)
        assert_equal 15, espiral.pos(3,3)
        assert_equal 6, espiral.pos(4,3)
        assert_equal 10, espiral.pos(1,4)
        assert_equal 9, espiral.pos(2,4)
        assert_equal 8, espiral.pos(3,4)
        assert_equal 7, espiral.pos(4,4)
    end
  end

  describe "matrix de 6 linhas" do
    it "uma espiral 5, 6 deve retornar a matriz:
        1  2  3  4  5
        18 19 20 21  6
        17 28 29 22  7
        16 27 30 23  8
        15 26 25 24  9
        14 13 12 11 10
      " do
        espiral = Espiral.new 5, 6
        assert_equal 1, espiral.pos(1,1)
        assert_equal 2, espiral.pos(2,1)
        assert_equal 3, espiral.pos(3,1)
        assert_equal 4, espiral.pos(4,1)
        assert_equal 5, espiral.pos(5,1)
        assert_equal 18, espiral.pos(1,2)
        assert_equal 19, espiral.pos(2,2)
        assert_equal 20, espiral.pos(3,2)
        assert_equal 21, espiral.pos(4,2)
        assert_equal 6, espiral.pos(5,2)
        assert_equal 17, espiral.pos(1,3)
        assert_equal 28, espiral.pos(2,3)
        assert_equal 29, espiral.pos(3,3)
        assert_equal 22, espiral.pos(4,3)
        assert_equal 7, espiral.pos(5,3)
        assert_equal 16, espiral.pos(1,4)
        assert_equal 27, espiral.pos(2,4)
        assert_equal 30, espiral.pos(3,4)
        assert_equal 23, espiral.pos(4,4)
        assert_equal 8, espiral.pos(5,4)
        assert_equal 15, espiral.pos(1,5)
        assert_equal 26, espiral.pos(2,5)
        assert_equal 25, espiral.pos(3,5)
        assert_equal 24, espiral.pos(4,5)
        assert_equal 9, espiral.pos(5,5)
        assert_equal 14, espiral.pos(1,6)
        assert_equal 13, espiral.pos(2,6)
        assert_equal 12, espiral.pos(3,6)
        assert_equal 11, espiral.pos(4,6)
        assert_equal 10, espiral.pos(5,6)
    end
  end

end
