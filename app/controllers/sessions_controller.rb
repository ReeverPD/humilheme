# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

class SessionsController < ApplicationController
  
  def create
    user = User.from_omniauth(env["omniauth.auth"])
    session[:user_id] = user.id
    session[:token] = user.oauth_token
    redirect_to convidar_amigo_path
  end

  def destroy
    session[:user_id] = nil
    redirect_to root_url
  end
  
  
end