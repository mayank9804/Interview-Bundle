**Rate Limiter** - An important component of a system architecture 
that helps ensure highly availabile and resilient system. It does that by
throttling any requests that exceed an agreed threshold for a client.

**Why not scale and handle excess traffic ?**
* The system could be chain of several components, which would be needed to scale. It can take time, and what if some of your downstream doesn't scale well, and you never expected to pass down that much traffic to it. You could unintentionally break a circuit of microservices.
* Cost parameter might also be a factor. Imagine your lambda scaling to handle an artificial traffic attack on your system, and you are paying for that.

**Requirements**
* **Functional Requirement** - 
  1. Given a request by a client, either allow or throttle it.
* **Non Functional Requirement** - 
  1. Low Latency
  2. Scalable
  3. Accurate
  4. Easily Integrable 

