# encoding: utf-8

class Espiral
  attr_accessor :coluna, :linha, :tamanho

  def initialize x, y
    @coluna = x
    @linha = y
    @tamanho = @coluna * @linha
  end

  def pos x, y
    if y == 1              # Primeira linha
      x
    elsif @coluna == x
      calc_ultima_coluna y
    elsif @linha == y 
      calc_ultima_linha x
    elsif x == 1 
      calc_primeira_coluna y
    else
      interna = Espiral.new(@coluna - 2, @linha - 2)
      interna.pos(x - 1, y - 1) + @tamanho - interna.tamanho
    end
  end

private
  def calc_ultima_coluna y
    y + @coluna - 1
  end

  def calc_ultima_linha x
    @tamanho - (@linha - 2) - (x - 1) - Espiral.new(@coluna - 2, @linha - 2).tamanho
  end

  def calc_primeira_coluna y
    @tamanho - (y - 2) - Espiral.new(@coluna - 2, @linha - 2).tamanho
  end

end
