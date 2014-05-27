Rails.application.routes.draw do
  
  

  root :to => "home#welcome"
  
  # HOME
  get  'termos-de-utilizacao', to: "home#termos"
  get  'policita-de-privacidade', to: "home#politica"
  get  'contato', to: "home#contato"
  resources :home do
    
  end
  
  post '/doar/:msg', to: 'mensagems#doar', as: :msg
  resources :mensagems do
    
  end
  
  
  
  #facebook
  match 'auth/:provider/callback', to: 'sessions#create', via: [:get, :post]
  match 'auth/failure', to: redirect('/'), via: [:get, :post]
  match 'signout', to: 'sessions#destroy', as: 'signout', via: [:get, :post]
  
  
  
end
