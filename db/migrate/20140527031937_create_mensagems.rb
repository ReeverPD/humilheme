class CreateMensagems < ActiveRecord::Migration
  def change
    create_table :mensagems do |t|
      t.string :msg

      t.timestamps
    end
  end
end
