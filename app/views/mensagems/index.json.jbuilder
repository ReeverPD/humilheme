json.array!(@mensagems) do |mensagem|
  json.extract! mensagem, :id, :msg
  json.url mensagem_url(mensagem, format: :json)
end
