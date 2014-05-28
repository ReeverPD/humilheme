Rails.application.routes.draw do
  
  

  root :to => "home#welcome"
  
  # HOME
  get  'termos-de-utilizacao', to: "home#termos"
  get  'policita-de-privacidade', to: "home#politica"
  get  'contato', to: "home#contato"
  resources :home do
    
  end
  
  #Mensagens
  post '/doar/:msg', to: 'mensagems#doar', as: :msg
  resources :mensagems do
    
  end
  
  # Convidar
  get '/convidar-amigo', to: 'convidar#convidar_amigo'
  post '/convidar/pesquisar', :controller => 'convidar', :action => 'pesquisa_amigo', as: :nome_amigo
  post '/convidar/invite', :controller => 'convidar', :action => 'invite_amigo'
  resources :convidar do
    
  end
  
  
  
  
  
  
  
  #facebook
  match 'auth/:provider/callback', to: 'sessions#create', via: [:get, :post]
  match 'auth/failure', to: redirect('/'), via: [:get, :post]
  match 'signout', to: 'sessions#destroy', as: 'signout', via: [:get, :post]
  
  
  
end
