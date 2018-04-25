require 'net/http'

describe 'server' do 
  describe '/' do 
    it 'should return open positions' do
      uri = URI(ENV['API_URI'])
      res = Net::HTTP.get(uri)
      expect(res).to eq('{"dev":"http://jobs.soluto.com/apply/NxK0Kn/Senior-Software-Engineer","dev-ops":"http://jobs.soluto.com/apply/y05XIq/Production-Engineer-DevOps","pm":"http://jobs.soluto.com/apply/izeE6HhNuv/Senior-Product-Manager","ux":"http://jobs.soluto.com/apply/9lFp0fCtus/Graphic-Designer"}')
    end
  end
end 
