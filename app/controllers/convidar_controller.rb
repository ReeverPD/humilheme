# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

class ConvidarController < ApplicationController
  
  layout 'interno'
  
  # GET /Convidar-Amigo
  def convidar_amigo
    @userRequest = false
    fb_friends
    
  end
  
  # GET /pesquisa/?nomeAmigo=
  def pesquisa_amigo
    @userRequest = false
    fb_friends
    
    render :template => "convidar/convidar_amigo"
  end
  
  
  # GET /convidar/invite
  def invite_amigo
    
    graph = Koala::Facebook::API.new(session[:token])
    
    begin
    
      if params[:tipo] == '0'
        msg = params[:convidar][:friendName] + ' seu amigo ' + graph.get_object(:me)["name"] + ' quer ser xingado, venha e faça seu dia!'
      else
        msg = params[:convidar][:friendName] + ' seu amigo ' + graph.get_object(:me)["name"] + ' quer iniciar uma batalha de xingamentos, venha e faça seu dia!'
      end

      graph.put_object(params[:convidar][:friendId], "apprequests", {:message=> msg})

      rescue Koala::Facebook::APIError => e
        @userRequest = true
        @userId = params[:convidar][:friendId]
        @msg = msg
    end
    
    fb_friends
    
    render :template => "convidar/convidar_amigo"
  end
  
  private
  
  def fb_friends
    @graph = Koala::Facebook::API.new(session[:token])

    begin
      @friends = @graph.get_connections("me", "friends").select{ |e| 
        e["name"].downcase().include? params[:convidar][:nome_amigo].downcase()
      }.slice(0,25)

    rescue NoMethodError
      @friends = @graph.get_connections("me", "friends", {:offset=>0 ,:limit => 25})
    end
  end
  
  
  
end
