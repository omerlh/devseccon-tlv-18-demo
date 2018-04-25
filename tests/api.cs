using System;
using System.Net.Http;
using Newtonsoft.Json;
using Xunit;

namespace tests
{
    public class UnitTest1
    {
        [Fact]
        public async void Return_All_Open_Positions()
        {
          var client = new HttpClient();
          var url = Environment.GetEnvironmentVariable("API_URI");
          var response = await client.GetAsync(url);
          response.EnsureSuccessStatusCode();
          var responseData = await response.Content.ReadAsStringAsync();

          var openPositions = JsonConvert.DeserializeObject<dynamic>(responseData);

          Assert.Equal("http://jobs.soluto.com/apply/NxK0Kn/Senior-Software-Engineer", openPositions.dev.Value);

        }
    }
}
